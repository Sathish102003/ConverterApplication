package com.convert.service.adapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JAXBJodaDateTimeAdapter extends XmlAdapter<String, DateTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_WITH_MILLIS =
            DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'.'SSS");

    public JAXBJodaDateTimeAdapter() {
    }

    public DateTime unmarshal(String date) throws Exception {
        return date == null ? null :
                (date.contains(".") ? FORMATTER_WITH_MILLIS.parseDateTime(date) : FORMATTER.parseDateTime(date));
    }

    public String marshal(DateTime date) throws Exception {
        return date == null ? null :
                (0 == date.getMillisOfSecond() ? FORMATTER.print(date) : FORMATTER_WITH_MILLIS.print(date));
    }
}
