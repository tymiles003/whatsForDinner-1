package org.home.whatsfordinner.config.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DateTimeModule extends SimpleModule {

    @Override
    public void setupModule(SetupContext context) {
        {
            final SimpleSerializers serializers = new SimpleSerializers();
            serializers.addSerializer(DateTime.class, new DateTimeSerializer());
            context.addSerializers(serializers);
        }
        {
            final SimpleDeserializers deserializers = new SimpleDeserializers();
            deserializers.addDeserializer(DateTime.class, new DateTimeDeserializer());
            context.addDeserializers(deserializers);
        }
    }

    private class DateTimeSerializer extends JsonSerializer<DateTime> {

        @Override
        public void serialize(final DateTime value, final JsonGenerator jsonGenerator, final SerializerProvider provider) throws IOException {
            jsonGenerator.writeString(String.valueOf(value.getMillis()));
        }
    }

    private class DateTimeDeserializer extends JsonDeserializer<DateTime> {

        @Override
        public DateTime deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
            return new DateTime(jp.getValueAsLong());
        }
    }
}
