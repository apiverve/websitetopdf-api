# Website to PDF API - Go Client

Website to PDF is a simple tool for converting a website to PDF. It returns the PDF file generated from the website.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Website to PDF API](https://apiverve.com/marketplace/websitetopdf?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/websitetopdf-api/go
```

---

## Configuration

Before using the Website to PDF API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Website to PDF API documentation is found here: [https://docs.apiverve.com/ref/websitetopdf](https://docs.apiverve.com/ref/websitetopdf?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/websitetopdf-api/go"
)

func main() {
    // Create a new client
    client := websitetopdf.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "marginTop": 0.4,
        "marginBottom": 0.4,
        "marginLeft": 0.4,
        "marginRight": 0.4,
        "landscape": false,
        "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

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
    "pdfName": "75a31d2a-c96d-428d-9c1e-63795d54f74c.pdf",
    "expires": 1740260149292,
    "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts",
    "downloadURL": "https://storage.googleapis.com/apiverve-helpers.appspot.com/websitetopdf/75a31d2a-c96d-428d-9c1e-63795d54f74c.pdf?GoogleAccessId=1089020767582-compute%40developer.gserviceaccount.com&Expires=1740260149&Signature=GSNCajtyCCkRJEd2n%2FEJ7z6a6E5oa3VmeK5Qkk9P3uYEAFsz4xVNnqZpZ4LDPJhKY9ea8ii1jNX5iKQabiTikwz%2Bg9g1kTxB5572oFPnsWAiaCreKeim3MzuczZRXtLnKpoCEMZWf6aGbYn7kRfKc47tFFbicx74isqxx6Lzs%2BMjKa3k33NUxH9JjQYeStWtnvI9DZorXgpUvjH8QL2H%2FU8wpZSIgpZAY8LMBo07PfWAO2ulinprBnTGhqIErIs71E6CPXnYuRo8r2ZOenQKkTsYNPXXt8vRK9eBh70dBVMEjfYQQA5tyauKvBNdpAmG3DLiKLATut55aKeicioejA%3D%3D"
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
