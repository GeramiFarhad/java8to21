package eleven.modules.TestModuleFarm3.farm.vet.farm.vet;

import eleven.modules.TestModuleFarm3.farm.animals.farm.cattle.Cattle;
import eleven.modules.TestModuleFarm3.farm.owner.farm.owner.Owner;

public class VetMain {
    public static void main(String[] args) {
        // dealing with Owner
        Owner owner = new Owner();
        System.out.println(owner.getAnimal("C2"));

        Cattle cattle = new Cattle();
        // do Cattle stuff...
        System.out.println("There are "+cattle.getTotal()+" cattle in total");
    }
}

//  javac -d out -m farm.vet,farm.owner,farm.animals --module-source-path .\src\eleven\modules\TestModuleFarm3\
//  java -p out -m farm.vet/eleven.modules.TestModuleFarm3.farm.vet.farm.vet.VetMain


//  jar -cvf mods/farm.animals.jar -C out/farm.animals/ .
//  jar -cvf mods/farm.owner.jar -C out/farm.owner/ .
//  jar -cvf mods/farm.vet.jar -C out/farm.vet/ .
//  java -p mods -m farm.vet/eleven.modules.TestModuleFarm3.farm.vet.farm.vet.VetMain