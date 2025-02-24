class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("old feature and should not be used.");
    }

    void newFeature() {
        System.out.println("new and improved feature.");
    }
}

public class DeprecatedEx {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Warning: Deprecated method
        api.newFeature();
    }
}
