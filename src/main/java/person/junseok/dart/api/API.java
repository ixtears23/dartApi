package person.junseok.dart.api;

public enum API {

    KEY("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    private String value;

    API(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
