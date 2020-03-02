package tw.nekomimi.nekogram;

import android.content.Context;
import android.content.SharedPreferences;

import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.FileLog;
import org.telegram.messenger.MessagesController;

public class NekoXConfig {

    public static int[] DEVELOPER_IDS = {896711046,899300686,339984997};

    private static SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekox_config", Context.MODE_PRIVATE);

    public static boolean disableChatAction;

    public static boolean developerModeEntrance;
    public static boolean developerMode;

    public static boolean disableFlagSecure;
    public static boolean disableScreenshotDetection;

    public static boolean showTestBackend;
    public static boolean showBotLogin;

    public static boolean sortByUnread;
    public static boolean sortByUnmuted;
    public static boolean sortByUser;
    public static boolean sortByContacts;
    public static boolean sortBySendTime;

    public static boolean disableUndo;

    static {

        disableChatAction = preferences.getBoolean("disable_chat_action", false);

        developerMode = preferences.getBoolean("developer_mode",false);

        disableFlagSecure = preferences.getBoolean("disable_flag_secure", false);
        disableScreenshotDetection = preferences.getBoolean("disable_screenshot_detection",false);

        showTestBackend = preferences.getBoolean("show_test_backend",false);
        showBotLogin = preferences.getBoolean("show_bot_login",false);

        sortByUnread = preferences.getBoolean("sort_by_unread",true);
        sortByUnmuted = preferences.getBoolean("sort_by_unmuted",true);
        sortByUser = preferences.getBoolean("sort_by_user",false);
        sortByContacts = preferences.getBoolean("sort_by_contacts",true);
        sortBySendTime = preferences.getBoolean("sort_by_send_time",true);

        disableUndo = preferences.getBoolean("disable_undo",true);

    }

    public static void toggleDisableChatAction() {

        preferences.edit().putBoolean("disable_chat_action", disableChatAction = !disableChatAction).apply();

    }

    public static void toggleDeveloperMode() {

        preferences.edit().putBoolean("developer_mode", developerMode = !developerMode).apply();

    }

    public static void toggleDisableFlagSecure() {

        preferences.edit().putBoolean("disable_flag_secure", disableFlagSecure = !disableFlagSecure).apply();

    }

    public static void toggleDisableScreenshotDetection() {

        preferences.edit().putBoolean("disable_screenshot_detection", disableScreenshotDetection = !disableScreenshotDetection).apply();

    }

    public static void toggleShowTestBackend() {

        preferences.edit().putBoolean("show_test_backend", showTestBackend = !showTestBackend).apply();

    }

    public static void toggleShowBotLogin() {

        preferences.edit().putBoolean("show_bot_login", showBotLogin = !showBotLogin).apply();

    }

    public static void toggleSortByUnread() {

        preferences.edit().putBoolean("sort_by_unread", sortByUnread = !sortByUnread).apply();

    }

    public static void toggleSortByUnmuted() {

        preferences.edit().putBoolean("sort_by_unmuted", sortByUnmuted = !sortByUnmuted).apply();

    }

    public static void toggleSortByUser() {

        preferences.edit().putBoolean("sortByUser", sortByUser = !sortByUser).apply();

    }

    public static void toggleSortByContacts() {

        preferences.edit().putBoolean("show_bot_login", sortByContacts = !sortByContacts).apply();

    }

    public static void toggleSortBySendTime() {

        preferences.edit().putBoolean("sort_by_send_time", sortBySendTime = !sortBySendTime).apply();

    }

    public static void toggleDisableUndo() {

        preferences.edit().putBoolean("disable_undo", disableUndo = !disableUndo).apply();

    }

}
