import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;

/**
 * CityPopulationAnalyzer
 * 
 * This program reads city names and population data from a file and stores them
 * in sorted arrays. The data is sorted as it's read in, preparing it for 
 * efficient searching using binary search.
 * 
 * YOUR TASK:
 * Complete the methods marked with TODO comments
 */
public class CityPopulationAnalyzer {
    
    private String[] cityNames;      // Array to store city names
    private double[] populations;    // Array to store populations
    private int count;               // Track how many cities we've read
    private static final int INITIAL_CAPACITY = 150; // Start with capacity for ~150 cities
    
    /**
     * Constructor - initializes the arrays
     */
    public CityPopulationAnalyzer() {
        // TODO: Initialize cityNames array with INITIAL_CAPACITY
        // TODO: Initialize populations array with INITIAL_CAPACITY
        // TODO: Set count to 0
        cityNames = new String[INITIAL_CAPACITY];
        populations = new double[INITIAL_CAPACITY];
        count = 0;
    }
    
    /**
     * Reads city data from a file and inserts it into sorted arrays
     * 
     * File format:
     * City Name
     * Population (as number)
     * City Name
     * Population (as number)
     * ... (alternating pattern)
     * 
     * @param filename the path to the data file
     * @throws FileNotFoundException 
     * @throws IOException, InputMismatchException if the file cannot be found or read
     */
    public void readAndSortData(String filename) throws IOException  {
        // TODO: Create a File object with the filename
        // TODO: Create a Scanner to read from the file
        Scanner scanner = new Scanner(new File(filename));

        // TODO: Read pairs of city name and population
        // HINT: Use a while loop with scanner.hasNextLine()
        // HINT: Read city name first, then check if there's a population line
        // HINT: Parse the population as a double (use Double.parseDouble())
        // HINT: Call insertSorted() for each city/population pair
        // HINT: If array is full, call resizeArrays()
        // TODO: Close the scanner

        while(scanner.hasNextLine()){
            String name = scanner.nextLine();
            Double pop = Double.parseDouble(scanner.nextLine());
            insertSorted(name, pop);
        }
        
        System.out.println("Successfully read " + count + " cities from " + filename);
    }
    
    /**
     * Inserts a city and its population into the arrays in sorted order
     * (sorted by population, highest to lowest)
     * 
     * @param cityName the name of the city
     * @param population the population of the city
     */
    private void insertSorted(String cityName, double population) {
        // TODO: Find the correct position for insertion
        // HINT: Start at 0 and go to count - why count?
        // HINT: Loop through existing elements to find where this population should go
        // HINT: We want highest populations first, so insert before any smaller population
        
        if(count >= cityNames.length)
            resizeArrays();

        int insert = count;
        for(int i = 0; i < count; i++){
            if(population > populations[i])
                insert = i;
        }

        // TODO: Shift elements to the right to make room
        // HINT: Start from 0 and move to correct position
        // HINT: Move both cityNames and populations arrays
        for(int i = count; i > insert; i--){
            populations[i] = populations[i-1];
            cityNames[i] = cityNames[i-1];
        }
        
        // TODO: Insert the new city and population at the correct position
        populations[insert] = population;
        cityNames[insert] = cityName;
        // TODO: Increment count
        count++;
    }
    
    /**
     * Doubles the size of the arrays when they get full
     */
    private void resizeArrays() {
        // TODO: Create new arrays twice the current size
        String[] temp = new String[populations.length * 2];
        double[] temp2 = new double[populations.length * 2];
        // TODO: Copy all existing data to the new arrays
        // HINT: Use a loop from 0 to count
        for(int i = 0 ; i < populations.length; i++){
            temp2[i] = populations[i];
            temp[i] = cityNames[i];
        }
        // TODO: Update the instance variables to point to the new arrays
        populations = temp2;
        cityNames = temp;

        System.out.println("Arrays resized to capacity: " + cityNames.length);
    }
    
    /**
     * Displays the top N cities by population
     */
    public void displayTopCities(int n) {
        System.out.println("\n=== Top " + n + " Cities by Population ===");
        // TODO go for it
        for(int i = 0; i < n; i++){
            System.out.println(cityNames[i] + " " + populations[i]);
        }
    }
    
        
    /**
     * Returns the number of cities loaded
     */
    public int getCount() {
        //TODO
        return count;
    }

    /**
     * Returns the largest population (arrays are sorted high to low)
     */
    public double getLargestPopulation() {
        //TODO
        return populations[0];
    }

    /**
     * Returns the city name with the largest population
     */
    public String getCityWithLargestPopulation() {
        //TODO
        return cityNames[0];
    }

    /**
     * Returns the smallest population (arrays are sorted high to low)
     */
    public double getSmallestPopulation() {
        //TODO
        return populations[count - 1];
    }

    /**
     * Returns the city name with the smallest population
     */
    public String getCityWithSmallestPopulation() {
        //TODO
        return cityNames[count - 1];
    }

    /**
     * Returns the population for a given city name
     * @param cityName the city to find
     * @return the population if found, or -1 if not found
     */
    public double findPopulationOfCity(String cityName) {
        // TODO
        int i = 0;
        while(!cityNames[i].equals(cityName)){
            i++;
        }
        return populations[i];
    }

    /**
     * Returns true if the city name exists in the array
     * Must use binary search
     * @param cityName the city to search for
     * @return true if found, false otherwise
     */
    public boolean containsCityName(String cityName) {
        // TODO
        rearrange();

        int jump = count / 2;
        while(!cityName.equals(cityNames[jump])){
            jump = 
        }
        return true;
    }

    public void rearrange(){
        for(int i = 0; i < count - 1; i++){
            for(int j = 1; j < count; j++)
            if(cityNames[i].compareTo(cityNames[j]) > 0){
                String temp = cityNames[i];
                cityNames[i] = cityNames[j];
                cityNames[j] = temp;
                double temp2 = populations[i];
                populations[i] = populations[j];
                populations[j] = temp2;
            }
        }
    }

    /**
     * Returns the average population of all cities
     * @return average population, or 0 if no cities
     */
    public double averagePopulationSize() {
        // TODO
        double sum = 0;
        for(double d : populations)
            sum += d;
        return sum/count;
    }
    
    
}
