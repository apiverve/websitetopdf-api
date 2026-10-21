# Website to PDF API - PHP Package

Website to PDF renders any public web page into a PDF document from a submitted URL. It returns a temporary signed download link, unique filename, and expiration timestamp, with paid plans adding custom margins and landscape layout.

## Installation

Install via Composer:

```bash
composer require apiverve/websitetopdf
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Websitetopdf\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'marginTop' => 0.4,
    'marginBottom' => 0.4,
    'marginLeft' => 0.4,
    'marginRight' => 0.4,
    'landscape' => false,
    'url' => 'https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Websitetopdf\Client;
use APIVerve\Websitetopdf\Exceptions\APIException;
use APIVerve\Websitetopdf\Exceptions\ValidationException;

try {
    $response = $client->execute(['marginTop' => 0.4, 'marginBottom' => 0.4, 'marginLeft' => 0.4, 'marginRight' => 0.4, 'landscape' => false, 'url' => 'https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/websitetopdf?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/websitetopdf?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/websitetopdf?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
