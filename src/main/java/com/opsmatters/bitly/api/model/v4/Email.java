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

import com.google.gson.annotations.SerializedName;

/**
 * Represents the attributes of a user's email address.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Email
{
    private String email;

    @SerializedName("is_primary")
    private boolean isPrimary;

    @SerializedName("is_verified")
    private boolean isVerified;

    /**
     * Default constructor.
     */
    public Email()
    {
    }

    /**
     * Returns the address of the email.
     * @return The address of the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Returns <CODE>true</CODE> if the email is the primary address.
     * @return <CODE>true</CODE> if the email is the primary address
     */
    public boolean isPrimary()
    {
        return isPrimary;
    }

    /**
     * Returns <CODE>true</CODE> if the email address has been verified.
     * @return <CODE>true</CODE> if the email address has been verified
     */
    public boolean isVerified()
    {
        return isVerified;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Email ["
            +"email="+email
            +", isPrimary="+isPrimary
            +", isVerified="+isVerified
            +"]";
    }
}