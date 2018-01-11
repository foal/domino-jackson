/*
 * Copyright 2013 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.progressoft.brix.domino.jacksonapt.deser.array.cast;

import com.progressoft.brix.domino.jacksonapt.JacksonContextProvider;
import com.progressoft.brix.domino.jacksonapt.JsonDeserializationContext;
import com.progressoft.brix.domino.jacksonapt.JsonDeserializer;
import com.progressoft.brix.domino.jacksonapt.JsonDeserializerParameters;
import com.progressoft.brix.domino.jacksonapt.deser.BaseNumberJsonDeserializer.ShortJsonDeserializer;
import com.progressoft.brix.domino.jacksonapt.deser.array.AbstractArrayJsonDeserializer;
import com.progressoft.brix.domino.jacksonapt.stream.JsonReader;

/**
 * Default {@link JsonDeserializer} implementation for array of short.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveShortArrayJsonDeserializer extends AbstractArrayJsonDeserializer<short[]> {

    private static final PrimitiveShortArrayJsonDeserializer INSTANCE = new PrimitiveShortArrayJsonDeserializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveShortArrayJsonDeserializer}
     */
    public static PrimitiveShortArrayJsonDeserializer getInstance() {
        return INSTANCE;
    }



    private PrimitiveShortArrayJsonDeserializer() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short[] doDeserializeArray(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
       return JacksonContextProvider.get().shortArrayReader().readArray(reader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected short[] doDeserializeSingleArray(JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params) {
        return new short[]{ShortJsonDeserializer.getInstance().deserialize(reader, ctx, params)};
    }
}