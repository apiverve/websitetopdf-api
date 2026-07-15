# Website to PDF API

Website to PDF is a simple tool for converting a website to PDF. It returns the PDF file generated from the website.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)
[![npm version](https://img.shields.io/npm/v/@apiverve/websitetopdf.svg)](https://www.npmjs.com/package/@apiverve/websitetopdf)

This is a Javascript Wrapper for the [Website to PDF API](https://apiverve.com/marketplace/websitetopdf?utm_source=npm&utm_medium=readme)

---

## Installation

Using npm:
```shell
npm install @apiverve/websitetopdf
```

Using yarn:
```shell
yarn add @apiverve/websitetopdf
```

---

## Configuration

Before using the Website to PDF API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=npm&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=npm&utm_medium=readme)

The Website to PDF API documentation is found here: [https://docs.apiverve.com/ref/websitetopdf](https://docs.apiverve.com/ref/websitetopdf?utm_source=npm&utm_medium=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const websitetopdfAPI = require('@apiverve/websitetopdf');
const api = new websitetopdfAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  "marginTop": 0.4,
  "marginBottom": 0.4,
  "marginLeft": 0.4,
  "marginRight": 0.4,
  "landscape": false,
  "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  "marginTop": 0.4,
  "marginBottom": 0.4,
  "marginLeft": 0.4,
  "marginRight": 0.4,
  "landscape": false,
  "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  "marginTop": 0.4,
  "marginBottom": 0.4,
  "marginLeft": 0.4,
  "marginRight": 0.4,
  "landscape": false,
  "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
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
    "pdfName": "128deceb-c515-444b-8863-82cb3f6ba632.pdf",
    "expires": 1766097122116,
    "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts",
    "downloadURL": "https://storage.googleapis.com/apiverve-helpers.appspot.com/websitetopdf/128deceb-c515-444b-8863-82cb3f6ba632.pdf?GoogleAccessId=1089020767582-compute%40developer.gserviceaccount.com&Expires=1766097122&Signature=LI747FKqKj5i5TYX3KIoVy%2FHgXsLOSXfVEUM0Ekqz2SiiYOZWuk3Of7QBDUklSrcbjiHV0AjbzFTKt6oDU83UkN282HbmhxwrolN6v1Zb9twVi1y7gmTpapCiJi%2BpA1r89ioe%2Fe0%2FV7KrIWaqsorzpdJrnMqe2izMWBaZq%2FYkSO2qlwSyhg2R8EsfxYNAANtd%2FuNS0RuIzqTdhNCiTrRirnDAKS3dMCySQJRznHFnyqzNj1OXwVjvdpSMn9XhWCUa%2FDRR8q%2BE9B0yF8eTvIrDSe2OzJT%2FJLc9rxcLfXAny21gtNqrzMJPU4yM9Ge%2BEbepmDnNZf9xpODNsnq5eLF0g%3D%3D"
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=npm&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=npm&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=npm&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=npm&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
