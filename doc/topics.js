/* http://wiki.openstreetmap.org/wiki/Map_Features */
/*
./mongo server:27017/dbname --quiet my_commands.js
In my_commands.js:
db.users.insert({name:"john", email:"john@doe.com", age:12});
*/

var sustenance = {key:"sustenance", val:"Food & Drink"}
var education = {key:"education", val:"Education"}
var transportation={key:"transportation", val:"Transportation"}
var financial={key:"financial", val:"Financial"}
var healthcare={key:"healthcare", val:"Health care"} /*Not done*/
var entertainment={key:"entertainment", val:"Entertainment, Arts & Culture"}
var others="Others" /*Not done*/
var

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
        image:"http://wiki.openstreetmap.org/wiki/File:Bar_MXCT.JPG",
        icon:""
      },
      {
        key:"bbq",
        name:"BBQ",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"BBQ or Barbecue is a permanently built grill for cooking food, which is most typically used outdoors by the public. For example these may be found in city parks or at beaches.",
        image:"http://wiki.openstreetmap.org/wiki/File:Grillplatzusa.jpg",
        icon:""
      },
      {
        key:"biergarten",
        name:"Biergarten",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Biergarten or beer garden is an open-air area where alcoholic beverages along with food is prepared and served.",
        image:"http://wiki.openstreetmap.org/wiki/File:Biergarten.JPG",
        icon:""
      },
      {
        key:"cafe",
        name:"Cafe",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Cafe is generally an informal place that offers casual meals and beverages, typically, the focus is on coffee or tea.",
        image:"http://wiki.openstreetmap.org/wiki/File:Klagenfurt_W%C3%B6rthersee_Strandbad_Cafe_Sunset_Bar_11102008_65.jpg",
        icon:""
      },
      {
        key:"drinking_water",
        name:"Drinking water",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Drinking water is a place where humans can obtain potable water for consumption. Typically, the water is used for only drinking.",
        image:"http://wiki.openstreetmap.org/wiki/File:Basler_Trinkwasser_1341.jpg",
        icon:""
      },
      {
        key:"fast_food",
        name:"Fast Food",
        enabled:true,
        group: {key:sustenance["key"], name:sustenance["val"]},
        description:"Fast food restaurants",
        image:"http://wiki.openstreetmap.org/wiki/File:Burger_king_kamen_osm.jpg",
        icon:""
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
        key:"college",
        name:"College",
        enabled:false,
        group: {key:education["key"], name:education["val"]},
        description:"A college campus or buildings",
        image:"http://wiki.openstreetmap.org/wiki/File:Cambridge_Regional_College_main_entrance.jpg"
      },
      {
        key:"kindergarten",
        name:"kindergarten",
        enabled:false,
        group: {key:education["key"], name:education["val"]},
        description:"For children too young for a regular school (also known as playschool or nursery school).",
        image:"http://wiki.openstreetmap.org/wiki/File:Story_Time.jpg"
      },
      {
        key:"library",
        name:"Library",
        enabled:false,
        group: {key:education["key"], name:education["val"]},
        description:"A public library (municipal, university, …) to borrow books from.",
        image:"http://wiki.openstreetmap.org/wiki/File:Guantanamo_captives%27_library_a.jpg"
      },
      {
        key:"public_bookcase",
        name:"Public Bookcase",
        enabled:false,
        group: {key:education["key"], name:education["val"]},
        description:"A street furniture containing books. Take one or leave one.",
        image:"http://wiki.openstreetmap.org/wiki/File:Hannover,_public_bookcase.jpg"
      },
      {
        key:"school",
        name:"School",
        enabled:false,
        group: {key:education["key"], name:education["val"]},
        description:"School and grounds",
        image:"http://wiki.openstreetmap.org/wiki/File:Williamstown_school.jpg"
      },
      {
        key:"university",
        name:"University",
        enabled:true,
        group: {key:education["key"], name:education["val"]},
        description:"An university campus",
        image:"http://wiki.openstreetmap.org/wiki/File:Brock_University_campus.JPG"
      },
      {
        key:"bicycle_parking",
        name:"Bicycle Parking",
        enabled:true,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Parking for bicycles",
        image:"http://wiki.openstreetmap.org/wiki/File:Bicycle-parking.jpg"
      },
      {
        key:"bicycle_repair_station",
        name:"Bicycle repair station",
        enabled:true,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Self service repair stand",
        image:"http://wiki.openstreetmap.org/wiki/File:BikeRepairMonterrey.JPG"
      },
      {
        key:"bicycle_rental",
        name:"Bicycle rental",
        enabled:true,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Rent a bicycle",
        image:"http://wiki.openstreetmap.org/wiki/File:Bicycle-rental.jpg"
      },
      {
        key:"boat_sharing",
        name:"Boat sharing",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Share a Boat",
        image:"http://wiki.openstreetmap.org/wiki/File:A_Boat_To_Share.jpg"
      },
      {
        key:"car_rental",
        name:"Car rental",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Rent a car",
        image:"http://wiki.openstreetmap.org/wiki/File:Hertz_car_rental_office_Livonia_Michigan.JPG"
      },
      {
        key:"car_sharing",
        name:"car_sharing",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Share a car",
        image:"http://wiki.openstreetmap.org/wiki/File:U_Car_Share_Shattuck_Hearst.jpg"
      },
      {
        key:"car_wash",
        name:"Car wash",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"	Node Area	Wash a car",
        image:"http://wiki.openstreetmap.org/wiki/File:Wuppertal_-_Friedrich-Engels-Allee_130_02_ies.jpg"
      },
      {
        key:"charging_station",
        name:"charging_station",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"	Node	Charging facility for electric vehicles",
        image:"http://wiki.openstreetmap.org/wiki/File:Evpost.jpg"
      },
      {
        key:"ferry_terminal",
        name:"Ferry terminal",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Ferry terminal/stop. A place where people/cars/etc. can board and leave a ferry.",
        image:"http://wiki.openstreetmap.org/wiki/File:Ferry_Reet.jpg"
      },
      {
        key:"fuel",
        name:"Fuel",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Petrol station, gas station, marine fuel",
        image:"http://wiki.openstreetmap.org/wiki/File:Preem_Karlskrona.jpg"
      },
      {
        key:"grit_bin",
        name:"Grit bin",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"A container that holds grit or a mixture of salt and grit.",
        image:"http://wiki.openstreetmap.org/wiki/File:Grit_bin.jpg"
      },
      {
        key:"motorcycle_parking",
        name:"Motorcycle parking",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Parking for motorcycles",
        image:"http://wiki.openstreetmap.org/wiki/File:Motorradparkplatz_Gifhorn_M%C3%BChlenmuseum.jpg"
      },
      {
        key:"parking",
        name:"Parking",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"Car park.",
        image:"http://wiki.openstreetmap.org/wiki/File:P3030027ParkingLot_wb.jpg"
      },
      {
        key:"parking_entrance",
        name:"Parking entrance",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"An entrance or exit to an underground or multi-storey parking facility.",
        image:"http://wiki.openstreetmap.org/wiki/File:3690668043_88a731e3e0_b.jpg"
      },
      {
        key:"parking_space",
        name:"Parking space",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"A single parking space.",
        image:"http://wiki.openstreetmap.org/wiki/File:138081166_2a56d66c27_b.jpg"
      },
      {
        key:"taxi",
        name:"Taxi",
        enabled:false,
        group: {key:transportation["key"], name:transportation["val"]},
        description:"A place where taxis wait for passengers.",
        image:"http://wiki.openstreetmap.org/wiki/File:Amenity_taxi_picture-Hong_Kong_Shatin_Taxi_Stand.jpg"
      },
      {
        key:"atm",
        name:"ATM",
        enabled:false,
        group: {key:financial["key"], name:financial["val"]},
        description:"An ATM or cash point",
        image:"http://wiki.openstreetmap.org/wiki/File:ATM_750x1300.jpg"
      },
      {
        key:"bank",
        name:"Bank",
        enabled:false,
        group: {key:financial["key"], name:financial["val"]},
        description:"Bank",
        image:"http://wiki.openstreetmap.org/wiki/File:Dscf1401-800.jpg"
      },
      {
        key:"bureau_de_change",
        name:"Currency Exchange",
        enabled:false,
        group: {key:financial["key"], name:financial["val"]},
        description:"Bureau de change, currency exchange, Wechsel, cambio – a place to change foreign bank notes and travellers cheques",
        image:"http://wiki.openstreetmap.org/wiki/File:Bureau_de_change_electronic_sign.jpg"
      },
      {
        key:"arts_centre",
        name:"Arts Centre",
        enabled:false,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A venue where a variety of arts are performed or conducted",
        image:"http://wiki.openstreetmap.org/wiki/File:Alhamra_Art_Centre.JPG"
      },
      {
        key:"brothel",
        name:"Brothel",
        enabled:false,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"An establishment specifically dedicated to prostitution",
        image:""
      },
      {
        key:"casino",
        name:"Casino",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A gambling venue with at least one table game (e.g. roulette, blackjack) that takes bets on sporting and other events at agreed upon odds.",
        image:"http://wiki.openstreetmap.org/wiki/File:Casin0.jpg"
      },
      {
        key:"cinema",
        name:"Cinema",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A place where films are shown (US: movie theater)",
        image:"http://wiki.openstreetmap.org/wiki/File:Palace_cin%C3%A9ma_beaumont.JPG"
      },
      {
        key:"community_centre",
        name:"Community Centre",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A place mostly used for local events and festivities.",
        image:"http://wiki.openstreetmap.org/wiki/File:Greasby_Community_Centre.JPG"
      },
      {
        key:"fountain",
        name:"Fountain",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A fountain for cultural / decorational / recreational purposes.",
        image:"http://wiki.openstreetmap.org/wiki/File:Fountain_at_Milan_citadel.JPG"
      }
      {
        key:"gambling",
        name:"Gambling",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A place for gambling. Games that are covered by this definition include bingo and pachinko.",
        image:"http://wiki.openstreetmap.org/wiki/File:Bingo_cards.jpg"
      },
      {
        key:"nightclub",
        name:"Nightclub",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A place to drink and dance.",
        image:"http://wiki.openstreetmap.org/wiki/File:Gatecrasher.jpg"
      },
      {
        key:"planetarium",
        name:"Planetarium",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A planetarium.",
        image:"http://wiki.openstreetmap.org/wiki/File:Planetarium.jpg"
      },
      {
        key:"social_centre",
        name:"Social Centre",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A place for free and not-for-profit activities.",
        image:"http://wiki.openstreetmap.org/wiki/File:Governor_Hotel,_Rotary_Club_of_Portland_plaque.JPG"
      },
      {
        key:"stripclub",
        name:"Stripclub",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A place that offers striptease or lapdancing",
        image:"http://wiki.openstreetmap.org/wiki/File:Stripclub.jpg"
      },
      {
        key:"studio",
        name:"Studio",
        enabled:false,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"TV radio or recording studio",
        image:"http://wiki.openstreetmap.org/wiki/File:DOUG.jpg"
      },
      {
        key:"swingerclub",
        name:"Swingerclub",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A club where people meet to have a party and group sex.",
        image:"http://wiki.openstreetmap.org/wiki/File:Swingerclub_C%C3%A4sars_Palace._Spr%C3%B6ckh%C3%B6vel.JPG"
      },
      {
        key:"theatre",
        name:"Theatre",
        enabled:true,
        group: {key:entertainment["key"], name:entertainment["val"]},
        description:"A theatre or opera house",
        image:"http://wiki.openstreetmap.org/wiki/File:Sydney_opera.jpg"
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
        image:"http://wiki.openstreetmap.org/wiki/File:Dscf0105_600.jpg"
      },
      {
        key:"aircraft",
        name:"Aircraft",
        enabled:false,
        group: {key:"", name:""},
        description:"A decommissioned aircraft which generally remains in one place",
        image:"http://wiki.openstreetmap.org/wiki/File:Historic_aircraft_monki.JPG"
      },
      {
        key:"battlefield",
        name:"Battlefield",
        enabled:false,
        group: {key:"", name:""},
        description:"The site of a battle or military skirmish in the past. This could be on land or at sea.",
        image:"http://wiki.openstreetmap.org/wiki/File:Fort_Donelson_river_battery_(1).jpg"
      },
      {
        key:"boundary_stone",
        name:"Boundary stone",
        enabled:false,
        group: {key:"", name:""},
        description:"A historic boundary stone usually found along the way.",
        image:"http://wiki.openstreetmap.org/wiki/File:Boundary_stone_St_Brelade_and_St_Peter,_Jersey.jpg"
      },
      {
        key:"castle",
        name:"Castle",
        enabled:false,
        group: {key:"", name:""},
        description:"Castles are (often fortified) buildings from medieval and modern times.",
        image:"http://wiki.openstreetmap.org/wiki/File:Dscf0226_600.jpg"
      },
      {
        key:"cannon",
        name:"Cannon",
        enabled:false,
        group: {key:"", name:""},
        description:"A historic/retired cannon. Usually found at on forts or battlefields.",
        image:"http://wiki.openstreetmap.org/wiki/File:Muzzle_loading_cannons_at_the_Swedish_Naval_Museum_(6648150909).jpg"
      },
      {
        key:"city_gate",
        name:"city_gate",
        enabled:false,
        group: {key:"", name:""},
        description:"A Wikipedia says: city gate (or town gate) is a gate within a city wall.",
        image:"http://wiki.openstreetmap.org/wiki/File:Spaarnwouder-_of_Amsterdamse_poort.jpg",
        link:"https://en.wikipedia.org/wiki/City_gate"
      },
      {
        key:"citywalls",
        name:"Citywalls",
        enabled:false,
        group: {key:"", name:""},
        description:"",
        image:"",
        link:"http://en.wikipedia.org/wiki/en:Defensive_wall"
      },
      {
        key:"farm",
        name:"Farm",
        enabled:false,
        group: {key:"", name:""},
        description:"A historical farm, kept in it's original state.",
        image:"http://wiki.openstreetmap.org/wiki/File:Memorial-Day-2003.jpg"
      },
      {
        key:"fort",
        name:"Fort",
        enabled:false,
        group: {key:"", name:""},
        description:"A military fort – distinct from a castle as it is generally more modern",
        image:"http://wiki.openstreetmap.org/wiki/File:Kom%C3%A1rom_Fortress_03.jpg"
      },
      {
        key:"manor",
        name:"Manor",
        enabled:false,
        group: {key:"", name:""},
        description:"	Node Area	Historic Wikipedia manors / Wikipedia mansions",
        image:"http://wiki.openstreetmap.org/wiki/File:Gut_Panker_Herrenhaus.jpg",
        link:"https://en.wikipedia.org/wiki/Manor_house"
      },
      {
        key:"memorial",
        name:"Memorial",
        enabled:false,
        group: {key:"", name:""},
        description:"Much like a monument, but smaller. Might range from a WWII memorial to a simple plate on a wall.",
        image:"http://wiki.openstreetmap.org/wiki/File:CIMG4191.JPG"
      },
      {
        key:"monument",
        name:"Monument",
        enabled:false,
        group: {key:"", name:""},
        description:"An object, especially large and made of stone, built to remember and show respect to a person or group of people.",
        image:"http://wiki.openstreetmap.org/wiki/File:Monument.JPG"
      },
      {
        key:"optical_telegraph",
        name:"Optical Telegraph",
        enabled:false,
        group: {key:"", name:""},
        description:"	Node Area	Historic optical telegraph",
        image:"http://wiki.openstreetmap.org/wiki/File:Telegraf-flittard.jpg"
      },
      {
        key:"ruins",
        name:"Ruins",
        enabled:true,
        group: {key:"", name:""},
        description:"Remains of structures that were once complete, but have fallen into partial or complete disrepair.",
        image:"http://wiki.openstreetmap.org/wiki/File:Dscf1813-800.jpg"
      },
      {
        key:"rune_stone",
        name:"Rune Stone",
        enabled:true,
        group: {key:"", name:""},
        description:"Rune stone is typically a raised stone with a runic inscription.",
        image:"http://wiki.openstreetmap.org/wiki/File:U_240,_Lingsberg.JPG",
        link:"http://en.wikipedia.org/wiki/en:Runestone"
      },
      {
        key:"ship",
        name:"Ship",
        enabled:true,
        group: {key:"", name:""},
        description:"A decommissioned ship or submarine.",
        image:"http://wiki.openstreetmap.org/wiki/File:Aurora_Cruiser_Museum_StPetersburg.JPG"
      },
      {
        key:"tomb",
        name:"Tomb",
        enabled:true,
        group: {key:"", name:""},
        description:"Historic tomb",
        image:"http://wiki.openstreetmap.org/wiki/File:Grob2.jpg"
      },
      {
        key:"wayside_cross",
        name:"Wayside Cross",
        enabled:true,
        group: {key:"", name:""},
        description:"A historical (usually christian) cross. Frequently found along the way in Southern Germany, Austria and probably elsewhere.",
        image:"http://wiki.openstreetmap.org/wiki/File:Wegkreuz.jpg"
      },
      {
        key:"wayside_shrine",
        name:"Wayside Shrine",
        enabled:true,
        group: {key:"", name:""},
        description:"A historical shrine often showing a religious depiction. Frequently found along the way in Southern Germany, Austria and probably elsewhere.",
        image:"http://wiki.openstreetmap.org/wiki/File:2003-10-11_tanner_moor_36.JPG"
      },
      {
        key:"wreck",
        name:"Wreck",
        enabled:true,
        group: {key:"", name:""},
        description:"Nautical craft that has unintentionally been sunk or destroyed.",
        image:"http://wiki.openstreetmap.org/wiki/File:LovilleWreckRedsea.jpg"
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


