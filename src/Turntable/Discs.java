package Turntable;

import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;


public class Discs {

    Scanner input  = new Scanner(System.in);
    Random  random = new Random();

    private String  albumArtist;                            //  Artist
    private String  albumName;                              //  Album name
    private String  year;                                   //  Release year
    private String  notes;                                  //  Personal notes
    private int     uniqueID;                               //  Randomically generated ID
    private int     rate = 1;                               //  Rating from 1 to 5 stars
    private boolean isOneOfMyFavourites = false;            //  Is one of your favorite vinyl?

    public Discs()
    {
        //  Gets the basic album information from the user
        System.out.print("Name of the Album: ");
        this.albumName = input.nextLine();

        System.out.print("Artist: ");
        this.albumArtist = input.nextLine();

        System.out.print("Year: ");
        this.year = input.nextLine();

        System.out.print("Personal notes: ");
        this.notes = input.nextLine();

        System.out.print("Rate: ");
        this.rate = input.nextInt();

        //  Calls and alocate a unique ID to the album inserted
        GenerateId();

        //  Exibits the info of determined album
        PullFromDb();                                     //    Pulls from the main db (in the later versions)
        //JsonDummyDb();                                    //    Pulls from a Json mimicking a db,
                                                          //    Just to rapidly store data for later purposes


    }

    private void GenerateId()
    {
        //  Generate a unique ID to the album using
        //  A random picked number and then parsing it to a hexadecimal value
        this.uniqueID = random.nextInt(90000);
        uniqueID = Integer.parseInt(String.valueOf(uniqueID));
    }

    private void JsonDummyDb() throws IOException {
        //  Handles the Json parsing and mimics a local database
        //  For now, this is the way (in the mandalorian voice)
        //  The basic json file is populated with a Pink Floyd example album to debug
        String path = "//Turntable/utl/db.json";
        String contents;
        contents = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject dataBase = new JSONObject(contents);
        JSONObject albumName = dataBase.getJSONObject("albumName");

        //  Needs to handle the output of the json in the next revisions



    }

    private void Rating() {
        //  Implement a rating system to add the number of stars along user rate
        //  Example:
        //  Rating: 4 ★★★★☆
    }

    private void PushToDb()
    {
        //  Pushes data to the db
    }

    private void PullFromDb()
    {
        //  Pulls data from the db
        //  Need to build a db later using azure
        //  this is only for debug purposes
        System.out.println("Album: "  + albumName);
        System.out.println("Artist: " + albumArtist);
        System.out.println("Year: "   + year);
        System.out.println("Notes: "  + notes);
        System.out.println("Rating: " + rate + " \u2605");
        System.out.println("ID: "     + uniqueID);
    }

    public void IsFavorite()
    {
        //  To implement in the case of the album being one of the favourites in the collection
        this.isOneOfMyFavourites = false;
    }
}
