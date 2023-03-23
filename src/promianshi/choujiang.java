package promianshi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class choujiang {

    public static class Record {
        /**
         * 抽奖记录 id
         */
        int id;
        /**
         * 奖品类型  1 红包 2 游戏币
         */
        int type;
        /**
         * 奖品数量
         */
        int count;
    }

    public String choujiang(Record[] records) {
        if(records.length <= 10) {
            return "高概率";
        } else {
            List<Record> hongbao = Arrays.stream(records)
                    .filter(record -> Objects.equals(record.type, 1))
                    .collect(Collectors.toList());
            int hongbaoTotal = 0;
            for(Record record : hongbao) {
                hongbaoTotal += record.count;
            }
            List<Record> youxibi = Arrays.stream(records)
                    .filter(record -> Objects.equals(record.type, 2))
                    .collect(Collectors.toList());
            int youxibiTotal = 0;
            for(Record record : youxibi) {
                youxibiTotal += record.count;
            }
            if(hongbaoTotal > 40) {
                return "低概率";
            } else if(records.length > 30) {
                return "低概率";
            } else if(records.length > 15 && youxibiTotal > 300) {
                return "低概率";
            } else {
                return "中概率";
            }
        }
    }
}
