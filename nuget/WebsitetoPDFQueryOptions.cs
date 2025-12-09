using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.WebsitetoPDF
{
    /// <summary>
    /// Query options for the Website to PDF API
    /// </summary>
    public class WebsitetoPDFQueryOptions
    {
        /// <summary>
        /// The URL of the website to convert to PDF
        /// </summary>
        [JsonProperty("url")]
        public string Url { get; set; }

        /// <summary>
        /// The top margin of the PDF in inches (e.g., 0.4)
        /// </summary>
        [JsonProperty("marginTop")]
        public string MarginTop { get; set; }

        /// <summary>
        /// The right margin of the PDF in inches (e.g., 0.4)
        /// </summary>
        [JsonProperty("marginRight")]
        public string MarginRight { get; set; }

        /// <summary>
        /// The bottom margin of the PDF in inches (e.g., 0.4)
        /// </summary>
        [JsonProperty("marginBottom")]
        public string MarginBottom { get; set; }

        /// <summary>
        /// The left margin of the PDF in inches (e.g., 0.4)
        /// </summary>
        [JsonProperty("marginLeft")]
        public string MarginLeft { get; set; }
    }
}
