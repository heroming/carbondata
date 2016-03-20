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

package com.huawei.unibi.molap.engine.aggregator.impl;


/**
 *
 * This class will be used for aggregate tables. It is
 * overriding agg method. It will be used for getting the average of fact
 * count(average value)
 * 
 * Version 1.0
 */

public class AvgOfAvgAggregator extends AvgAggregator
{

    /**
     * 
     *serialVersionUID
     * 
     */
    private static final long serialVersionUID = 6482976744603672084L;

    /**
     * Overloaded Aggregate function will be used for Aggregate tables because
     * aggregate table will have fact_count as a measure.
     * 
     * @param newVal
     *          new value
     * @param factCount
     *          total fact count
     * 
     */
    @Override
    public void agg(double newVal, double factCount)
    {
        aggVal += (newVal * factCount);
        count += factCount;
        firstTime = false;
    }

}
