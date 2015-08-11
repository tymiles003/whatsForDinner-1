package org.home.whatsfordinner.config.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DateTimeModule extends SimpleModule {

    @Override
    public void setupModule(SetupContext context) {
        final SimpleSerializers serializers = new SimpleSerializers();
        serializers.addSerializer(DateTime.class, new DateTimeSerializer());
        context.addSerializers(serializers);
    }

    private class DateTimeSerializer extends JsonSerializer<DateTime> {

        private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");

        @Override
        public void serialize(final DateTime value, final JsonGenerator jsonGenerator, final SerializerProvider provider) throws IOException, JsonProcessingException {
            jsonGenerator.writeString(value.toString(formatter));
        }
    }
}
