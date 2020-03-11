/*
 * Copyright 2020 Gerald Curley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.opsmatters.bitly.api.model.v4;

/**
 * Represents a query based on units.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class UnitQuery
{
    private Unit unit = Unit.DAY;
    private int units = -1;
    private String unitReference;
    private int size = 50;

    /**
     * Default constructor.
     */
    public UnitQuery()
    {
    }

    /**
     * Returns the unit for the query (either "minute", "hour", "day", "week", "month").
     * @return The unit for the query
     */
    public Unit getUnit()
    {
        return unit;
    }

    /**
     * Sets the unit for the query (either "minute", "hour", "day", "week", "month").
     * @param unit The unit for the query
     */
    public void setUnit(Unit unit)
    {
        this.unit = unit;
    }

    /**
     * Returns the units for the query. A value of -1 returns all units available.
     * @return The units for the query
     */
    public int getUnits()
    {
        return units;
    }

    /**
     * Sets the units for the query. A value of -1 returns all units available.
     * @param units The units for the query
     */
    public void setUnits(int units)
    {
        this.units = units;
    }

    /**
     * Returns the most recent time for to pull metrics for (ISO-8601 timestamp).
     * @return The unit reference for the query
     */
    public String getUnitReference()
    {
        return unitReference;
    }

    /**
     * Sets the most recent time for to pull metrics for (ISO-8601 timestamp). Defaults to current time.
     * @param unitReference The unit reference for the query
     */
    public void setUnitReference(String unitReference)
    {
        this.unitReference = unitReference;
    }

    /**
     * Returns the quantity of items to be returned.
     * @return The size for the query
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Sets the quantity of items to be returned. Defaults to 50.
     * @param size The size for the query
     */
    public void setSize(int size)
    {
        this.size = size;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "UnitQuery ["
            +"unit="+unit
            +", units="+units
            +", unitReference="+unitReference
            +", size="+size
            +"]";
    }

    /**
     * Returns a builder for the query.
     * @return The builder instance.
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to make query construction easier.
     */
    public static class Builder
    {
        private UnitQuery query = new UnitQuery();

        /**
         * Sets the unit for the query.
         * @param unit The unit for the query
         * @return This object
         */
        public Builder unit(Unit unit)
        {
            query.setUnit(unit);
            return this;
        }

        /**
         * Sets the units for the query.
         * @param units The units for the query
         * @return This object
         */
        public Builder units(int units)
        {
            query.setUnits(units);
            return this;
        }

        /**
         * Sets the unit reference for the query.
         * @param unitReference The unit reference for the query
         * @return This object
         */
        public Builder unitReference(String unitReference)
        {
            query.setUnitReference(unitReference);
            return this;
        }

        /**
         * Sets the size for the query.
         * @param size The size for the query
         * @return This object
         */
        public Builder size(int size)
        {
            query.setSize(size);
            return this;
        }

        /**
         * Returns the configured query
         * @return The query instance
         */
        public UnitQuery build()
        {
            return query;
        }
    }
}