package com.tuyotuyo.notifybridge.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotificationReaderService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        // 通知をキャッチ
        val packageName = sbn.packageName // 通知元アプリのパッケージ名
        val notificationTitle = sbn.notification.extras.getString("android.title")
        val notificationText = sbn.notification.extras.getString("android.text")

        // 通知の内容をログに出力
        Log.d(TAG, "通知をキャッチしました:")
        Log.d(TAG, "アプリ: $packageName")
        Log.d(TAG, "タイトル: $notificationTitle")
        Log.d(TAG, "内容: $notificationText")
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        // 通知が削除されたときの処理（必要に応じて実装）
        Log.d(TAG, "通知が削除されました: " + sbn.packageName)
    }

    companion object {
        private const val TAG = "NotificationReader"
    }
}
