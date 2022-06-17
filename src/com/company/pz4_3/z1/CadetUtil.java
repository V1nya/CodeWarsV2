package com.company.pz4_3.z1;

public class CadetUtil {

    public static void main(String[] args) {
        String[] fName = {"Вася", "Максим", "Петя"};
        String[] lName = {"Пупкин", "Петров", "Максимов"};

        var cadet = renderCadets(fName,lName,5);
        var f =  CadetUtil.Search(cadet,1);
    }
    public static void PrintAll(Cadet[] cadets) {
        for (var cad : cadets) {
            System.out.println(cad.toString());
        }

    }

    static Cadet[] renderCadets(String[] fName, String[] lName, int countCadet) {
        Cadet[] cadets = new Cadet[countCadet];
        for (int i = 0; i < countCadet; i++) {
            cadets[i] = new Cadet().of(i, fName[(int) (Math.random() * fName.length)],
                    lName[(int) (Math.random() * lName.length)],
                    (SpecialityTrends.values())[(int) (Math.random() * SpecialityTrends.values().length)]);
        }
        return cadets;
    }

    public static void PrintInfo(Cadet[] cadets, int id) {
        System.out.println();
    }

    public static Cadet Delete(Cadet[] cadets, int id) {
        Cadet cadet = new Cadet();

        for (int i = 0; i < cadets.length; i++) {

            if (cadets[i].id == id) {
                cadet = cadets[i];
                cadets[i] = null;
            }
        }

        return cadet;
    }

    public static void Insert(Cadet[] cadets, Cadet cadet) {
        for (int i = 0; i < cadets.length; i++) {
            if (cadets[i] == null) {
                cadets[i] = cadet;
                break;
            }
        }
    }

    public static Cadet Search(Cadet[] cadets, int id) {
        int mid;
        int l = 0;
        int r = cadets.length;
        while (true) {
            mid = l + ((r - l) / 2);
            if (cadets[mid].id == id) {

                return cadets[mid];
            } else {
                if (cadets[mid].id > id) {
                    r = mid;

                } else if (cadets[mid].id < id) {
                    l = mid;
                }
            }

        }
    }


}
