package com.taxcalculator;

public class Tax_Bikram {


        private double salary;

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
        public double getTaxAmount(){
            double salary = this.salary;
            if (salary == 0) {
                return 0;
            }else if (salary >=1 && salary <= 200000){
//            1 % of salary
                return .01*salary;
            }else if (salary > 200000 && salary <= 350000){
//            1 % of 200000 + 15 % of remaining
                return .01*200000 + .15*(salary-200000);
            }else{
//            1 % of 200000 + 15 % of 150000 + 25 % of remaining
                return .01*200000 + .15*150000 + .25 * (salary-350000);
            }
        }
    }

