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
           String title = m.getField("TITLE");
           String artist = m.getField("ARTIST");
           String year = m.getField("YEAR");
           String album = m.getField("ALBUM");
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