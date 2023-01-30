package cn.zm;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File source = FileUtil.newFile("asset/ccd1ab831790804c23f036612e4b05ffbd691bc5.json");
        File result = FileUtil.newFile("asset/Building Your English Brain01.txt");
        FileReader fileReader = FileReader.create(source);
        JSONObject jsonObject = JSONUtil.parseObj(fileReader.readString());
        JSONArray array = jsonObject.getJSONArray("body");
        String content = array.stream().map(o -> {
            JSONObject o1 = (JSONObject) o;
            return o1.getStr("content");
        }).collect(Collectors.joining(" "));

        FileWriter fileWriter = FileWriter.create(result);
        fileWriter.write(content);

    }
}