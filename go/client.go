// Package websitetopdf provides a Go client for the Website to PDF API.
//
// For more information, visit: https://apiverve.com/marketplace/websitetopdf?utm_source=go&utm_medium=readme
package websitetopdf

import (
	"errors"
	"fmt"
	"time"

	"github.com/go-resty/resty/v2"
)

const (
	baseURL        = "https://api.apiverve.com/v1/websitetopdf"
	defaultTimeout = 30 * time.Second
)

// Client is the Website to PDF API client.
type Client struct {
	apiKey     string
	httpClient *resty.Client
}

// NewClient creates a new Website to PDF API client.
func NewClient(apiKey string) *Client {
	client := resty.New()
	client.SetTimeout(defaultTimeout)
	client.SetHeader("Content-Type", "application/json")

	return &Client{
		apiKey:     apiKey,
		httpClient: client,
	}
}

// SetTimeout sets the HTTP client timeout.
func (c *Client) SetTimeout(timeout time.Duration) {
	c.httpClient.SetTimeout(timeout)
}


// Execute makes a request to the Website to PDF API with typed parameters.
//
// Parameters are validated before sending the request. If validation fails,
// an error is returned immediately without making a network request.
//
// Available parameters:
//   - url (required): string - The URL of the website to convert to PDF [format: url]
//   - marginTop: number - The top margin of the PDF in inches (e.g., 0.4)
//   - marginRight: number - The right margin of the PDF in inches (e.g., 0.4)
//   - marginBottom: number - The bottom margin of the PDF in inches (e.g., 0.4)
//   - marginLeft: number - The left margin of the PDF in inches (e.g., 0.4)
//   - landscape: boolean - Set to true for landscape orientation
func (c *Client) Execute(req *Request) (*Response, error) {
	if c.apiKey == "" {
		return nil, errors.New("API key is required. Get your API key at: https://apiverve.com")
	}

	// Validate parameters before making request
	if req != nil {
		if err := req.Validate(); err != nil {
			return nil, err
		}
	}

	request := c.httpClient.R().
		SetHeader("x-api-key", c.apiKey).
		SetResult(&Response{}).
		SetError(&ErrorResponse{})

	// POST request with JSON body
	resp, err := request.
		SetBody(req).
		Post(baseURL)

	if err != nil {
		return nil, fmt.Errorf("request failed: %w", err)
	}

	if resp.IsError() {
		if errResp, ok := resp.Error().(*ErrorResponse); ok {
			return nil, fmt.Errorf("API error: %s", errResp.Error)
		}
		return nil, fmt.Errorf("API error: status %d", resp.StatusCode())
	}

	result, ok := resp.Result().(*Response)
	if !ok {
		return nil, errors.New("failed to parse response")
	}

	return result, nil
}

// ExecuteRaw makes a request with a raw map of parameters (for dynamic usage).
func (c *Client) ExecuteRaw(params map[string]interface{}) (*Response, error) {
	if c.apiKey == "" {
		return nil, errors.New("API key is required. Get your API key at: https://apiverve.com")
	}

	request := c.httpClient.R().
		SetHeader("x-api-key", c.apiKey).
		SetResult(&Response{}).
		SetError(&ErrorResponse{})

	resp, err := request.
		SetBody(params).
		Post(baseURL)

	if err != nil {
		return nil, fmt.Errorf("request failed: %w", err)
	}

	if resp.IsError() {
		if errResp, ok := resp.Error().(*ErrorResponse); ok {
			return nil, fmt.Errorf("API error: %s", errResp.Error)
		}
		return nil, fmt.Errorf("API error: status %d", resp.StatusCode())
	}

	result, ok := resp.Result().(*Response)
	if !ok {
		return nil, errors.New("failed to parse response")
	}

	return result, nil
}

// Response represents the API response.
type Response struct {
	Status string       `json:"status"`
	Error  interface{}  `json:"error"`
	Data   ResponseData `json:"data"`
}

// ErrorResponse represents an error response from the API.
type ErrorResponse struct {
	Status string `json:"status"`
	Error  string `json:"error"`
}
