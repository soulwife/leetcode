<?php

class CalculateMinAngle {
  private const HOUR = 12;
  private const MINUTES = 60;
  private const DEGREE_MAX = 360;

  private function checkWrongInput(?int $hour, ?int $minutes): bool {
    return ($hour === null || $minutes === null || $hour > self::HOUR || $hour < 0 || $minutes > self::MINUTES || $minutes < 0);
  }

  public function calculateMinAngle(?int $hour, ?int $minutes): int {
    if ($this->checkWrongInput(12, 30)) {
      throw new Exception("Please check your numbers. Hour needs to be between 0 and 12 and minutes are 0 to 60."); 
    }

    $hour = $hour !== self::HOUR ? $hour : 0;
    $minutes = $minutes !== self::MINUTES ? $minutes : 0;
    if ($minutes === self::MINUTES) $hour+=1;

    $hourAngle = 0.5 * ($hour * self::MINUTES);
    $minuteAngle = 6 * $minutes;
    $angle = abs($hourAngle - $minuteAngle);
    return min(360 - $angle, $angle);
  }

}

$angleClassObject = new CalculateMinAngle();
try {
  echo "Min angle is " . $angleClassObject->calculateMinAngle(15,30);
} catch (Exception $e) {
  echo $e->getMessage();
}

?>
