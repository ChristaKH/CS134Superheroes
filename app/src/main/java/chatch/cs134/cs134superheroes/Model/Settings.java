package chatch.cs134.cs134superheroes.Model;

public class Settings {
    private String mSettingType;
    private String mSettingSummary;

    public Settings(String settingType, String settingSummary) {
        mSettingType = settingType;
        mSettingSummary = settingSummary;
    }

    public String getSettingType() {
        return mSettingType;
    }

    public void setSettingType(String settingType) {
        mSettingType = settingType;
    }

    public String getSettingSummary() {
        return mSettingSummary;
    }

    public void setSettingSummary(String settingSummary) {
        mSettingSummary = settingSummary;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "mSettingType='" + mSettingType + '\'' +
                ", mSettingSummary='" + mSettingSummary + '\'' +
                '}';
    }
}
