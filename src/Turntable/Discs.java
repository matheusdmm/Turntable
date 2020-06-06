package Turntable;

import java.util.Scanner;
import java.util.Random;


public class Discs {
    //  Main declarations to push and pull from my future DB
    Scanner input  = new Scanner(System.in);
    Random  random = new Random();

    private String  albumArtist;
    private String  albumName;
    private String  year;
    private String  notes;
    private int     uniqueID;
    private int     rate = 1;
    private boolean isOneOfMyFavourites = false;

    public Discs()
    {
        //  Gets the basic album information
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

        //  Calls the unique ID
        GenerateId();

        //  Exibits the info of determined album
        PullFromDb();
    }

    private void GenerateId()
    {
        //  Generate a unique ID to the album using
        //  A random picked number and then parsing it to a hexadecimal value
        this.uniqueID = random.nextInt(90000);
        uniqueID = Integer.parseInt(String.valueOf(uniqueID));
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
        System.out.println("Rating: " + rate);
        System.out.println("ID: "     + uniqueID);
    }

    public void IsFavorite()
    {
        //  To implement in the case of the album being one of the favourites in the collection
        this.isOneOfMyFavourites = false;
    }
}
