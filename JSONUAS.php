<?php
header('Content-type: application/json');
$Objek = array(array("id"=>"1", "nama"=>"Muhammad Ujang", "asal_daerah"=>"bogor", "kamar"=>"Presiden"),
array("id"=>"2", "nama"=>"Ahmad Bambang", "asal_daerah"=>"Jakarta", "kamar"=>"Walikota"),
array("id"=>"3", "nama"=>"Asep Surasep", "asal_daerah"=>"Bandung", "kamar"=>"Gubernur"),
array("id"=>"4", "nama"=>"Budi Susanto", "asal_daerah"=>"Makassar", "kamar"=>"Lurah"),
array("id"=>"5", "nama"=>"Maman Abdurahman", "asal_daerah"=>"Sukabumi", "kamar"=>"Camat"));
$json = json_encode($Objek);
echo $json;
?>