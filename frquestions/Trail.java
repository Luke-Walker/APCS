public class Trail
{
 /** Representation of the trail. The number of markers on the trail is markers.length. */
 private int[] markers;

 /** Default Constructor */
 public Trail() {
   markers = new int[] {};
 }

 /** Constructor with Parameter */
 public Trail(int[] m) {
   markers = m;
 }


 /** Determines if a trail segment is level. A trail segment is defined by a starting marker,
 * an ending marker, and all markers between those two markers.
 * A trail segment is level if it has a difference between the maximum elevation
 * and minimum elevation that is less than or equal to 10 meters.
 * @param start the index of the starting marker
 * @param end the index of the ending marker
 * Precondition: 0 <= start < end <= markers.length - 1
 * @return true if the difference between the maximum and minimum
 * elevation on this segment of the trail is less than or equal to 10 meters;
 * false otherwise.
 */
 public boolean isLevelTrailSegment(int start, int end)
 { /* to be implemented in part (a) */
     int min = markers[start];
     int max = markers[start];

     for (int i = start+1; i < end; i++) {
         int marker = markers[i];

         if (marker < min) min = marker;
         if (marker > max) max = marker;
     }

     return max-min <= 10;
 }


 /** Determines if this trail is rated difficult. A trail is rated by counting the number of changes in
 * elevation that are at least 30 meters (up or down) between two consecutive markers. A trail
 * with 3 or more such changes is rated difficult.
 * @return true if the trail is rated difficult; false otherwise.
 */
 public boolean isDifficult()
 { /* to be implemented in part (b) */
     int count = 0;
     int last = markers[0];

     for (int i = 1; i < markers.length; i++) {
        int marker = markers[i];

        if (Math.abs(marker-last) >= 30) count++;

        last = marker;
     }

     return count >= 3;
 }


 // There may be instance variables, constructors, and methods that are not shown.
}
