<?php
$input = [
  "Selfie Stick,98,29",
  "iPhone Case,90,15",
  "Fire TV Stick,48,49",
  "Wyze Cam,48,25",
  "Water Filter,56,49",
  "Blue Light Blocking Glasses,90,16",
  "Ice Maker,47,119",
  "Video Doorbell,47,199",
  "AA Batteries,64,12",
  "Disinfecting Wipes,37,12",
  "Baseball Cards,73,16",
  "Winter Gloves,32,112",
  "Microphone,44,22",
  "Pet Kennel,5,24",
  "Jenga Classic Game,100,7",
  "Ink Cartridges,88,45",
  "Instant Pot,98,59",
  "Hoze Nozzle,74,26",
  "Gift Card,45,25",
  "Keyboard,82,19"
  ];

  $titles = $sortedRecords = $records = [];

  foreach ($input as $value) {
    list($title, $popularity, $price) = explode(',', $value);
    $records[] = ['title' => $title, 'popularity' => $popularity, 'price' => $price];
  }
  for ($i=0;$i<count($records);$i++) {
    if ($records[$i]['popularity'] == $records[$i+1]['popularity']) {
      $sortedRecords[] = ($records[$i]['price'] <= $records[$i+1]['price']) ? $records[$i] : $records[$i+1]; 
    } else {
      var_dump($records[$i]['popularity'], $records[$i+1]['popularity']);
      $sortedRecords[] = ($records[$i]['popularity'] > $records[$i+1]['popularity']) ? $records[$i] : $records[$i+1];
    }
  }

  foreach($sortedRecords as $record) {
    $titles[] = $record['title'];
  
  }
  var_dump($titles);
?>
