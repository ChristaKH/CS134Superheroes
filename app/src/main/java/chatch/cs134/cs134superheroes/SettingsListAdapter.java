/**
 * This class handles the list items in the list view in the
 * settings activity
 */
package chatch.cs134.cs134superheroes;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import chatch.cs134.cs134superheroes.Model.Settings;

public class SettingsListAdapter extends ArrayAdapter<Settings> {

    private Context mContext;
    private List<Settings> mSettingsList = new ArrayList<>();
    private int mResourceId;

    /**
     * Full constructor
     * @param c
     * @param rID
     * @param settings
     */
    public SettingsListAdapter(Context c, int rID, List<Settings> settings){
        super(c, rID, settings);
        mContext = c;
        mSettingsList = settings;
        mResourceId = rID;
    }

    /**
     * Gets the view associated with the layout.
     * @param pos The position of the College selected in the list.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {


        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);
        view.setTag(pos);

        // DONE:  Write the code to correctly inflate the view (college_list_item) with
        // DONE:  all widgets filled with the appropriate College information.
        // Inflate our custom layout with data from the List
        Settings focusedSetting = mSettingsList.get(pos);

        // Fill the view
        TextView settingOptionTextView = view.findViewById(R.id.settingOptionTextView);
        TextView quizTypeSummaryTextView = view.findViewById(R.id.quizTypeSummaryTextView);

        settingOptionTextView.setText(focusedSetting.getSettingType());
        quizTypeSummaryTextView.setText(focusedSetting.getSettingSummary());

        return view;
    }
}
