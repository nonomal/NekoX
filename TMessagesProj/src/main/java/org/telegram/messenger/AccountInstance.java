package org.telegram.messenger;

import android.content.SharedPreferences;

import org.telegram.tgnet.ConnectionsManager;

import java.io.File;

public class AccountInstance {

    private int currentAccount;
    private static volatile AccountInstance[] Instance = new AccountInstance[UserConfig.MAX_ACCOUNT_COUNT];
    public static AccountInstance getInstance(int num) {
        AccountInstance localInstance = Instance[num];
        if (localInstance == null) {
            synchronized (AccountInstance.class) {
                localInstance = Instance[num];
                if (localInstance == null) {
                    Instance[num] = localInstance = new AccountInstance(num);
                }
            }
        }
        return localInstance;
    }

    public AccountInstance(int instance) {
        currentAccount = instance;
    }

    public MessagesController getMessagesController() {
        return MessagesController.getInstance(currentAccount);
    }

    public MessagesStorage getMessagesStorage() {
        return MessagesStorage.getInstance(currentAccount);
    }

    public ContactsController getContactsController() {
        return ContactsController.getInstance(currentAccount);
    }

    public MediaDataController getMediaDataController() {
        return MediaDataController.getInstance(currentAccount);
    }

    public ConnectionsManager getConnectionsManager() {
        return ConnectionsManager.getInstance(currentAccount);
    }

    public NotificationsController getNotificationsController() {
        return NotificationsController.getInstance(currentAccount);
    }

    public NotificationCenter getNotificationCenter() {
        return NotificationCenter.getInstance(currentAccount);
    }

    public LocationController getLocationController() {
        return LocationController.getInstance(currentAccount);
    }

    public UserConfig getUserConfig() {
        return UserConfig.getInstance(currentAccount);
    }

    public DownloadController getDownloadController() {
        return DownloadController.getInstance(currentAccount);
    }

    public SendMessagesHelper getSendMessagesHelper() {
        return SendMessagesHelper.getInstance(currentAccount);
    }

    public SecretChatHelper getSecretChatHelper() {
        return SecretChatHelper.getInstance(currentAccount);
    }

    public StatsController getStatsController() {
        return StatsController.getInstance(currentAccount);
    }

    public FileLoader getFileLoader() {
        return FileLoader.getInstance(currentAccount);
    }

    public FileRefController getFileRefController() {
        return FileRefController.getInstance(currentAccount);
    }

    public SharedPreferences getNotificationsSettings() {
        return MessagesController.getNotificationsSettings(currentAccount);
    }

    public void shift() {

        File cfgDir = new File(ApplicationLoader.applicationContext.getFilesDir().getParentFile(), "shared_prefs");

        File currCfg = new File(cfgDir, "mainconfig" + currentAccount);

        File prefCfg;

        if (currentAccount == 1) {

            prefCfg = new File(cfgDir, "mainconfig");

        } else {

            prefCfg = new File(cfgDir, "mainconfig" + (currentAccount - 1));

        }

        try {

            prefCfg.delete();

            currCfg.renameTo(prefCfg);

        } catch (Exception e) {

            FileLog.e(e);

        }

        Instance[currentAccount - 1] = this;

        getMessagesController().shift();
        getMessagesStorage().shift();
        getContactsController().shift();
        getMediaDataController().shift();
        getConnectionsManager().shift();
        getNotificationsController().shift();
        getLocationController().shift();
        getDownloadController().shift();
        getSecretChatHelper().shift();
        getStatsController().shift();
        getFileLoader().shift();
        getFileRefController().shift();


        // TODO shift shared prefs

        currentAccount --;

    }
}
