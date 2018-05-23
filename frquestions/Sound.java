public class Sound
{
 /** the array of values in this sound; guaranteed not to be null */
 private int[] samples;

 /** Default Constructor */
 public Sound() {
   samples = new int[] {};
 }

 /** Constructor with Parameter */
 public Sound(int[] s) {
   samples = s;
 }

 /** Get the array of samples */
 public int[] getSamples() {
   return samples;
 }

 /** Changes those values in this sound that have an amplitude greater than limit.
 * Values greater than limit are changed to limit.
 * Values less than -limit are changed to -limit.
 * @param limit the amplitude limit
 * Precondition: limit ≥ 0
 * @return the number of values in this sound that this method changed
 */
 public int limitAmplitude(int limit)
 { /* to be implemented in part (a) */
   int count = 0;

   for (int i = 0; i < samples.length; i++) {
       int sample = samples[i];

       if (sample > limit) {
           samples[i] = limit;
       } else if (sample < -limit) {
           samples[i] = -limit;
       } else {
           continue;
       }
       count++;
   }

   return count;
 }


 /** Removes all silence from the beginning of this sound.
 * Silence is represented by a value of 0.
 * Precondition: samples contains at least one nonzero value
 * Postcondition: the length of samples reflects the removal of starting silence
 */
 public void trimSilenceFromBeginning()
 { /* to be implemented in part (b) */
     int count = 0;
     for (int i = 0; i < samples.length; i++) {
         int sample = samples[i];
         if (sample == 0) count++;
         else break;
     }

     int[] trim = new int[samples.length-count];
     for (int i = count; i < samples.length; i++) {
         trim[i-count] = samples[i];
     }

     samples = trim;
 }

 // There may be instance variables, constructors, and methods that are not shown.
}
