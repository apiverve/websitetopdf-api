Website to PDF API
============

Website to PDF is a simple tool for converting a website to PDF. It returns the PDF file generated from the website.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Website to PDF API](https://apiverve.com/marketplace/api/websitetopdf)

---

## Installation
	pip install apiverve-websitetopdf

---

## Configuration

Before using the websitetopdf API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Website to PDF API documentation is found here: [https://docs.apiverve.com/api/websitetopdf](https://docs.apiverve.com/api/websitetopdf).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_websitetopdf.apiClient import WebsitetopdfAPIClient

# Initialize the client with your APIVerve API key
api = WebsitetopdfAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "marginTop": 0.4, "marginBottom": 0.4, "marginLeft": 0.4, "marginRight": 0.4, "landscape": false, "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts" }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
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

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.