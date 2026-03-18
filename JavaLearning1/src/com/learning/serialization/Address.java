package com.learning.serialization;

import java.io.Serializable;

class Address  implements Serializable {
    String city;
    String state;

    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}