package homework.java8.streams.yesterdey;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    @SneakyThrows
    public static long countWords(String song) {
        return Files.lines(Path.of(song))
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .count();
    }

    public static void main(String[] args) {
        System.out.println(countWords("data\\song.txt"));

        Map<Integer, String> t = new HashMap<>(Map.of(1, "t"));
        System.out.println(t.put(2, "r"));

    }
}
