package com.netease.xmpp.robot;

import com.netease.xmpp.master.client.ClientGlobal;
import com.netease.xmpp.master.client.TaskExecutor;
import com.netease.xmpp.master.event.client.UpdateCompletedEventHandler;

public class RobotUpdateCompletedEventHandler extends UpdateCompletedEventHandler {
    @Override
    public void allHashUpdated() {
        checkRobotStatus();
    }

    @Override
    public void allServerUpdated() {
        checkRobotStatus();
    }

    private void checkRobotStatus() {
        if (!ClientGlobal.getIsUpdating()) {
            if (!ClientGlobal.getIsClientStartup()) {
                Robot.getInstance().start();
            }

            // TODO thread numbers
            TaskExecutor.getInstance(1).resume();
        }
    }
}
