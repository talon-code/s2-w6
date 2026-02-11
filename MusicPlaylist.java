/**
 * MusicPlaylist - Manages a playlist of song titles
 * 
 * Complete the insertSong() and removeSong() methods
 */
public class MusicPlaylist {
    private String[] songs;
    private int count;  // number of songs currently in playlist
    private int capacity;

    public MusicPlaylist(int capacity) {
        songs = new String[capacity];
        count = 0;
        this.capacity = capacity;
    }
    
    // Add song to the end of playlist
    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        }
    }
    
    // Get song at position
    public String getSong(int position) {
        return songs[position];
    }
    
    // Return number of songs
    public int size() {
        return count;
    }

    public int capacity() {
        return capacity;
    }
    
    // Double the size of the array when it gets full
    private void resizeArray() {
        // TODO: Implement resize
        // 1. Create a new array twice the size of the current one
        // 2. Copy all songs from the old array to the new array
        // 3. Update the songs reference to point to the new array
        int i = 0;
        String[] temp = new String[capacity * 2];
        for(String s : songs){
            temp[i] = s;
            i++;
        }
        songs = temp;
        capacity = 2 * capacity;

    }
    
    // INSERT song at specific position
    // Example: Insert "Bohemian Rhapsody" at position 2
    // Shifts all songs after position 2 to the right
    public void insertSong(int position, String title) {
        // TODO: Implement insert
        // 1. Check if there's room in the array (if not, call resizeArray())
        // 2. Shift all songs from position to the right
        // 3. Place the new song at the position
        // 4. Increment count
        if(count >= songs.length)
            resizeArray();

        for(int i = count; i > position; i--){
            songs[i] = songs[i-1];
        }
        songs[position] = title;
        count++;
    }
    
    // REMOVE song at specific position
    // Example: Remove song at position 3
    // Shifts all songs after position 3 to the left
    public void removeSong(int position) {
        // TODO: Implement remove
        // 1. Shift all songs after position to the left
        // 2. Decrement count
        if(position < songs.length){
            for(int i = position; i < count; i++){
                songs[i] = songs[i+1];
            }
            songs[songs.length - 1] = null;
            count--;
        }
    }
    
    // Display all songs
    public void displayPlaylist() {
        System.out.println("=== My Playlist ===");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + songs[i]);
        }
    }
    
    // Test the MusicPlaylist class
    public static void main(String[] args) {
        MusicPlaylist myPlaylist = new MusicPlaylist(10);
        
        // Add some songs
        myPlaylist.addSong("Blinding Lights");
        myPlaylist.addSong("Shape of You");
        myPlaylist.addSong("Levitating");
        myPlaylist.addSong("Watermelon Sugar");
        
        System.out.println("Original playlist:");
        myPlaylist.displayPlaylist();
        
        //Test insert
        System.out.println("\nAfter inserting 'Bohemian Rhapsody' at position 2:");
        myPlaylist.insertSong(2, "Bohemian Rhapsody");
        myPlaylist.displayPlaylist();
        
        // Test remove
        System.out.println("\nAfter removing song at position 1:");
        myPlaylist.removeSong(1);
        myPlaylist.displayPlaylist();

    }
}