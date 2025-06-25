```
 (                (        *          
 )\ )       (     )\ )   (  `         
(()/( (     )\   (()/(   )\))(   (    
 /(_)))\ ((((_)(  /(_)) ((_)()\  )\   
(_)) ((_) )\ _ )\(_))_  (_()((_)((_)  
| _ \| __|(_)_\(_)|   \ |  \/  || __| 
|   /| _|  / _ \  | |) || |\/| || _|  
|_|_\|___|/_/ \_\ |___/ |_|  |_||___| 
```
**QUADIO**  
 - Playing audio files
 - Reading title, artist, and year from mp3s
 - Uses jaudiotagger and jlayer as dependencies
**USAGE**
 - **Metadata reading**
   ```java
   public class Main {
       public static void main(String[] args) throws Exception {
           Metadata m = new Metadata("path/to/your/mp3");
           m.load();
           String title = m.getField(Field.TITLE);
           String artist = m.getField(Field.ARTIST);
           String year = m.getField(Field.YEAR);
           String album = m.getField(Field.ALBUM);
       }
   }
 - **Metadata Writing**
   ```java
   public class Main {
       public static void main(String[] args) throws Exception {
           Metadata m = new Metadata("path/to/your/mp3");
           m.load();
           m.setField(Field.TITLE, "test");
       }
   }
     
 - **Sound playing**
   ```java
   public class Main {
       public static void main(String[] args) {
           Sound s = new Sound("path/to/your/mp3");
           sound.play();
       }
   }
 - **That's it!**
