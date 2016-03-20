/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.huawei.unibi.molap.engine.datastorage.storeInterfaces;

import java.util.List;

import com.huawei.unibi.molap.datastorage.store.FileHolder;
import com.huawei.unibi.molap.datastorage.store.compression.ValueCompressionModel;
import com.huawei.unibi.molap.engine.datastorage.streams.DataInputStream;
import com.huawei.unibi.molap.engine.scanner.Scanner;
import com.huawei.unibi.molap.metadata.MolapMetadata.Cube;

public interface DataStore
{

    KeyValue get(byte[] key, Scanner scanner);

    KeyValue getNext(byte[] key, Scanner scanner);
    
    DataStoreBlock getBlock(byte[] startKey, FileHolder fileHolderImpl, boolean isFirst);
    
    long size();

    long getRangeSplitValue();

    void build(List<DataInputStream> factStream, boolean hasFactCount);
    
    void buildColumnar(List<DataInputStream> factStream, boolean hasFactCount,Cube cube);

    /**
     * Gives different ranges based on number of keys
     * 
     * @return
     */
    long[][] getRanges();

    ValueCompressionModel getCompressionModel();
    
    void build(DataInputStream factStream, boolean hasFactCount);
}
