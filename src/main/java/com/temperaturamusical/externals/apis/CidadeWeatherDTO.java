package com.temperaturamusical.externals.apis;

public class CidadeWeatherDTO {

    private CurrentDTO current;
    private LocationDTO location;

    public CurrentDTO getCurrent() {
        return current;
    }

    public void setCurrent(CurrentDTO current) {
        this.current = current;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public class CurrentDTO {

        private Double temp_c;

        public Double getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(Double temp_c) {
            this.temp_c = temp_c;
        }
    }

    public class LocationDTO {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
