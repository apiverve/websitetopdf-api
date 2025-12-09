/**
 * Basic Example - Website to PDF API
 *
 * This example demonstrates how to use the Website to PDF API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const websitetopdfAPI = require('../index.js');

// Initialize the API client
const api = new websitetopdfAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  "marginTop": 0.4,
  "marginBottom": 0.4,
  "marginLeft": 0.4,
  "marginRight": 0.4,
  "landscape": false,
  "url": "https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts"
};

// Make the API request using callback
console.log('Making request to Website to PDF API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
