/* http://wiki.openstreetmap.org/wiki/Map_Features */

var sustenance = {key:"sustenance", val:"Food Drink"}
var education = {key:"education", val:"Education"}
var transportation={key:"transportation", val:"Transportation"}
var financial={key:"financial", val:"Financial"}
var healthcare={key:"healthcare", val:"Health care"}
var entertainmentName={key:"entertainment", val:"Entertainment, Arts & Culture"}
var others="Others"

db.topics.drop()
db.topics.insert(
  {key:"amenity", name:"Amenity", description:"Used to map facilities used by visitors and residents. For example: toilets, telephones, banks, pharmacies, cafes, parking and schools. See the page Amenities for an introduction on its usage.",
    subtopics :
    [
      {
        key:"bar",
        name:"Bar",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Bar is a purpose-built commercial establishment that sells alcoholic drinks to be consumed on the premises. They are characterised by a noisy and vibrant atmosphere, similar to a party and usually don't sell food.",
        image:"http://wiki.openstreetmap.org/wiki/File:Bar_MXCT.JPG"
      },
      {
        key:"bbq",
        name:"BBQ",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"BBQ or Barbecue is a permanently built grill for cooking food, which is most typically used outdoors by the public. For example these may be found in city parks or at beaches.",
        image:"http://wiki.openstreetmap.org/wiki/File:Grillplatzusa.jpg"
      },
      {
        key:"biergarten",
        name:"Biergarten",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Biergarten or beer garden is an open-air area where alcoholic beverages along with food is prepared and served.",
        image:"http://wiki.openstreetmap.org/wiki/File:Biergarten.JPG"
      },
      {
        key:"cafe",
        name:"Cafe",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Cafe is generally an informal place that offers casual meals and beverages, typically, the focus is on coffee or tea.",
        image:"http://wiki.openstreetmap.org/wiki/File:Klagenfurt_W%C3%B6rthersee_Strandbad_Cafe_Sunset_Bar_11102008_65.jpg"
      },
      {
        key:"drinking_water",
        name:"Drinking water",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Drinking water is a place where humans can obtain potable water for consumption. Typically, the water is used for only drinking.",
        image:"http://wiki.openstreetmap.org/wiki/File:Basler_Trinkwasser_1341.jpg"
      },
      {
        key:"fast_food",
        name:"Fast Food",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Fast food restaurants",
        image:"http://wiki.openstreetmap.org/wiki/File:Burger_king_kamen_osm.jpg"
      },
      {
        key:"food_court",
        name:"Food Court",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"An area with several different restaurant food counters and a shared eating area. Commonly found in malls, airports, etc.",
        image:""
      },
      {
        key:"ice_cream",
        name:"Ice cream",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"ce cream shop or ice cream parlour. A place that sells ice cream and frozen yoghurt over the counter",
        image:"http://wiki.openstreetmap.org/wiki/File:Shop-ice_cream.jpeg"
      },
      {
        key:"pub",
        name:"Pub",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"A place selling beer and other alcoholic drinks; may also provide food or accommodation (UK)",
        image:"http://wiki.openstreetmap.org/wiki/File:Pub.jpg"
      },
      {
        key:"restaurant",
        name:"Restaurant",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Restaurant",
        image:"http://wiki.openstreetmap.org/wiki/File:Caprice_Restaurant.JPG"
      },
      {
        key:"",
        name:"",
        enabled:true,
        group: {key:"", name:""},
        description:"",
        image:""
      }
    ]
   }
)


db.topics.insert(
  {name:"History", key:"historic", description:"This is used to describe various historic places. For example: archaeological sites, wrecks, ruins, castles and ancient buildings.",
   subtopics :
    [
      {
        key:"archaeological_site",
        name:"Archaeological site",
        enabled:false,
        group: {key:"", name:""},
        description:"A place in which evidence of past activity is preserved",
        image:""
      },
      {
        key:"aircraft",
        name:"Aircraft",
        enabled:false,
        group: {key:"", name:""},
        description:"A decommissioned aircraft which generally remains in one place",
        image:""
      },
      {
        key:"battlefield",
        name:"Battlefield",
        enabled:false,
        group: {key:"", name:""},
        description:"The site of a battle or military skirmish in the past. This could be on land or at sea.",
        image:""
      },
      {
        key:"boundary_stone",
        name:"Boundary stone",
        enabled:false,
        group: {key:"", name:""},
        description:"A historic boundary stone usually found along the way.",
        image:""
      },
      {
        key:"castle",
        name:"Castle",
        enabled:false,
        group: {key:"", name:""},
        description:"Castles are (often fortified) buildings from medieval and modern times.",
        image:""
      },
      {
        key:"cannon",
        name:"Cannon",
        enabled:false,
        group: {key:"", name:""},
        description:"A historic/retired cannon. Usually found at on forts or battlefields.",
        image:""
      },
      {
        key:"city_gate",
        name:"city_gate",
        enabled:false,
        group: {key:"", name:""},
        description:"A Wikipedia says: city gate (or town gate) is a gate within a city wall.",
        image:""
      },
      {
        key:"",
        name:"",
        enabled:true,
        group: {key:"", name:""},
        description:"",
        image:""
      },
      {
        key:"",
        name:"",
        enabled:true,
        group: {key:"", name:""},
        description:"",
        image:""
      },
      {
        key:"",
        name:"",
        enabled:true,
        group: {key:"", name:""},
        description:"",
        image:""
      }

    ]
   }
)


