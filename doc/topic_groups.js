/*
 Custon topics groups, to simplify searching
*/

db.topic_groups.insert(
[
  {
    key:"sustenance",val:"Food & Drink",
    group:["bar", "bbq", "biergarten", "cafe", "drinking_water", "fast_food", "food_court", "ice_cream", "pub", "restaurant"]
  },
  {
    key:"education",val:"Education",
    group:["collage", "kindergarten", "library", "public_bookcase"]
  }
])