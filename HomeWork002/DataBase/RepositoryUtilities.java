package HomeWork002.DataBase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import HomeWork002.Model.Person;
import HomeWork002.Model.Sex;


public class RepositoryUtilities {
    public List<Person> getList(String path){
        List<Person> persons = new ArrayList<>();
        String str = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((str = br.readLine()) != null)
            {
                persons.add(getPerson(str));
            }

            br.close();   
        } catch (Exception e) {
            System.out.println(e);
        }
        return persons;
    }

    private Person getPerson(String str){
        Sex currentSex;
        Integer motherId;
        Integer fatherId;
        List <Integer> brothersId = new ArrayList<>();
        List <Integer> sistersId = new ArrayList<>();
        List <Integer> sonsId = new ArrayList<>();
        List <Integer> daughtersId = new ArrayList<>();
        List <Integer> spousesId = new ArrayList<>();
        String[] arrayString = str.split(":");
        motherId = (arrayString[4].equals("null")) ? null : Integer.valueOf(arrayString[4]);
        fatherId = (arrayString[5].equals("null")) ? null : Integer.valueOf(arrayString[5]);
        currentSex = (arrayString[3].equals("м")) ? Sex.man : Sex.women;
        Arrays.asList(arrayString[6].split(" ")).stream().filter(n -> !n.equals("null")).forEach(n -> brothersId.add(Integer.valueOf(n)));
        Arrays.asList(arrayString[7].split(" ")).stream().filter(n -> !n.equals("null")).forEach(n -> sistersId.add(Integer.valueOf(n)));
        Arrays.asList(arrayString[8].split(" ")).stream().filter(n -> !n.equals("null")).forEach(n -> sonsId.add(Integer.valueOf(n)));
        Arrays.asList(arrayString[9].split(" ")).stream().filter(n -> !n.equals("null")).forEach(n -> daughtersId.add(Integer.valueOf(n)));
        Arrays.asList(arrayString[10].split(" ")).stream().filter(n -> !n.equals("null")).forEach(n -> spousesId.add(Integer.valueOf(n)));
        return new Person(Integer.valueOf(arrayString[0]), arrayString[2], arrayString[1], currentSex, motherId,
                            fatherId, brothersId, sistersId, sonsId, daughtersId, spousesId);
    }

}


