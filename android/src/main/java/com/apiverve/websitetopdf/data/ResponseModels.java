// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     WebsitetoPDFData data = Converter.fromJsonString(jsonString);

package com.apiverve.websitetopdf.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static WebsitetoPDFData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(WebsitetoPDFData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(WebsitetoPDFData.class);
        writer = mapper.writerFor(WebsitetoPDFData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// WebsitetoPDFData.java

package com.apiverve.websitetopdf.data;

import com.fasterxml.jackson.annotation.*;

public class WebsitetoPDFData {
    private String marginLeft;
    private String marginRight;
    private String marginTop;
    private String marginBottom;
    private boolean landscape;
    private String pdfName;
    private long expires;
    private String url;
    private String downloadURL;

    @JsonProperty("marginLeft")
    public String getMarginLeft() { return marginLeft; }
    @JsonProperty("marginLeft")
    public void setMarginLeft(String value) { this.marginLeft = value; }

    @JsonProperty("marginRight")
    public String getMarginRight() { return marginRight; }
    @JsonProperty("marginRight")
    public void setMarginRight(String value) { this.marginRight = value; }

    @JsonProperty("marginTop")
    public String getMarginTop() { return marginTop; }
    @JsonProperty("marginTop")
    public void setMarginTop(String value) { this.marginTop = value; }

    @JsonProperty("marginBottom")
    public String getMarginBottom() { return marginBottom; }
    @JsonProperty("marginBottom")
    public void setMarginBottom(String value) { this.marginBottom = value; }

    @JsonProperty("landscape")
    public boolean getLandscape() { return landscape; }
    @JsonProperty("landscape")
    public void setLandscape(boolean value) { this.landscape = value; }

    @JsonProperty("pdfName")
    public String getPDFName() { return pdfName; }
    @JsonProperty("pdfName")
    public void setPDFName(String value) { this.pdfName = value; }

    @JsonProperty("expires")
    public long getExpires() { return expires; }
    @JsonProperty("expires")
    public void setExpires(long value) { this.expires = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("downloadURL")
    public String getDownloadURL() { return downloadURL; }
    @JsonProperty("downloadURL")
    public void setDownloadURL(String value) { this.downloadURL = value; }
}