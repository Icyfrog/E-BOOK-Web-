package yqc.ebook.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class LogService {
    // mod 3 - 0, 1, 2
    private static int cur_idx = 0;

    public static void LOG(String level, String clsName, String detail) {
        String tableNameTemplate = "logfile%d";
        String cur_file = String.format(tableNameTemplate, cur_idx),
                next_file = String.format(tableNameTemplate, (cur_idx + 1) % 3);
        String ts = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());;
        String logTemplate = "%s %s --- [%s] %s";
        String value = String.format(logTemplate, ts, level, clsName, detail);
        boolean shouldUpdate = false;

        String cf = "log";
        if (!LogDao.isExist(cur_file)) {
            LogDao.createTable(cur_file, cf);
        }
        String column = "description";
        LogDao.addRow(cur_file, UUID.randomUUID().toString(), cf, column, value);
        if (LogDao.countRows(cur_file) >= 1000) {
            shouldUpdate = true;
        }
        if (LogDao.isExist(next_file)) {
            LogDao.deleteTable(next_file);
            LogDao.createTable(next_file, cf);
        } else LogDao.createTable(next_file, cf);

        if (shouldUpdate) {
            cur_idx = (cur_idx + 1) % 3;
        }
    }
}

