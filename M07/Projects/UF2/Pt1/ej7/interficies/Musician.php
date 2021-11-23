<?php
interface Musician
{
    public function addInstrument($instrument);
    public function getInstruments();
    public function assignToBand($band);
    public function getMusicianType();
}
