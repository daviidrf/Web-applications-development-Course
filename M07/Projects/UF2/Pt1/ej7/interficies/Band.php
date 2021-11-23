<?php
interface Band
{
    public function getName();
    public function getGenre();
    public function addMusician($musician);
    public function getMusicians();
}
