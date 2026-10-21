# Website to PDF API - Ruby Gem

Website to PDF renders any public web page into a PDF document from a submitted URL. It returns a temporary signed download link, unique filename, and expiration timestamp, with paid plans adding custom margins and landscape layout.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_websitetopdf'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_websitetopdf
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_websitetopdf'

# Initialize the client
client = APIVerve::Websitetopdf::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  marginTop: 0.4,
  marginBottom: 0.4,
  marginLeft: 0.4,
  marginRight: 0.4,
  landscape: false,
  url: "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ marginTop: 0.4, marginBottom: 0.4, marginLeft: 0.4, marginRight: 0.4, landscape: false, url: "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts" })
  puts response["data"]
rescue APIVerve::Websitetopdf::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Websitetopdf::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Websitetopdf::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "marginLeft": "0.4in",
    "marginRight": "0.4in",
    "marginTop": "0.4in",
    "marginBottom": "0.4in",
    "landscape": false,
    "pdfName": "128deceb-c515-444b-8863-82cb3f6ba632.pdf",
    "expires": 1766097122116,
    "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts",
    "downloadURL": "https://storage.googleapis.com/apiverve-helpers.appspot.com/websitetopdf/128deceb-c515-444b-8863-82cb3f6ba632.pdf?GoogleAccessId=1089020767582-compute%40developer.gserviceaccount.com&Expires=1766097122&Signature=LI747FKqKj5i5TYX3KIoVy%2FHgXsLOSXfVEUM0Ekqz2SiiYOZWuk3Of7QBDUklSrcbjiHV0AjbzFTKt6oDU83UkN282HbmhxwrolN6v1Zb9twVi1y7gmTpapCiJi%2BpA1r89ioe%2Fe0%2FV7KrIWaqsorzpdJrnMqe2izMWBaZq%2FYkSO2qlwSyhg2R8EsfxYNAANtd%2FuNS0RuIzqTdhNCiTrRirnDAKS3dMCySQJRznHFnyqzNj1OXwVjvdpSMn9XhWCUa%2FDRR8q%2BE9B0yF8eTvIrDSe2OzJT%2FJLc9rxcLfXAny21gtNqrzMJPU4yM9Ge%2BEbepmDnNZf9xpODNsnq5eLF0g%3D%3D"
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/websitetopdf?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/websitetopdf?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/websitetopdf?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
