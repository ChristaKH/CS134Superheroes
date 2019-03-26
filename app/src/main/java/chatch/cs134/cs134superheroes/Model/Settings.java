/**
 * The Settings class keeps track of the types of settings
 * that are available to the user. Setting class includes
 * the setting type and the setting summary.
 */
package chatch.cs134.cs134superheroes.Model;

public class Settings {
    private String mSettingType;
    private String mSettingSummary;

    /**
     * Full constructor that sets the setting type and the
     * setting summary.
     * @param settingType Type of setting that user can change
     * @param settingSummary String that is the summary of the setting
     *                       being adjusted.
     */
    public Settings(String settingType, String settingSummary) {
        mSettingType = settingType;
        mSettingSummary = settingSummary;
    }

    /**
     * Method that returns the type of setting available
     * @return the type of setting
     */
    public String getSettingType() {
        return mSettingType;
    }

    /**
     * Changes the type of setting being adjusted.
     * @param settingType   The new type of setting
     */
    public void setSettingType(String settingType) {
        mSettingType = settingType;
    }

    /**
     * Method that returns the String summary of the setting available.
     * @return  Setting summary
     */
    public String getSettingSummary() {
        return mSettingSummary;
    }

    /**
     * Method that sets the summary of the current setting
     * @param settingSummary    New summary for the current setting
     */
    public void setSettingSummary(String settingSummary) {
        mSettingSummary = settingSummary;
    }

    /**
     * Method that returns the String summary of the Setting
     * @return  String summary of setting
     */
    @Override
    public String toString() {
        return "Settings{" +
                "mSettingType='" + mSettingType + '\'' +
                ", mSettingSummary='" + mSettingSummary + '\'' +
                '}';
    }
}
