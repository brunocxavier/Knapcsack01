import com.fasterxml.jackson.databind.ObjectMapper;
import model.GreedyResponse;
import model.Instance;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length != 1){
            System.out.println("Maneira de usar: Passe apenas o path do arquivo de instancias como parametro");
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(args[0]);
        Instance instance = objectMapper.readValue(file, Instance.class);
        Greedy greedy = new Greedy();
        GreedyResponse greedyResponse = greedy.calculate(instance);
        System.out.println(greedyResponse);
    }
}
