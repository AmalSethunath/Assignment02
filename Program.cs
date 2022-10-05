using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_02
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Initialization of length and width of the rectangle
            int length;
            int width;
            bool validLength;
            bool validWidth;
        //Asking user to enter the input
        wrongInput:
            Console.WriteLine("Please enter the length and width of the rectangle");
            validLength = int.TryParse(Console.ReadLine(), out length);
            validWidth = int.TryParse(Console.ReadLine(), out width);
            Rectangle rectangle = new Rectangle(length, width);
            //Condition to check whether the given input is integer or not
            if (length < 0 || width < 0)
            {

                Console.WriteLine("\n You have entered wrong value");

                goto wrongInput;
            }
            else if (validWidth != true && validLength != true)
            {
                Console.WriteLine("\n You have entered wrong value");

                goto wrongInput;
            }

        //Asking user to enter the choice
        wrongChoice: Console.WriteLine("\n 1.Get Rectangle Length \n 2.Change Rectangle Length \n 3.Get Rectangle Width \n 4.Change Rectangle Width \n 5.Get Rectangle Perimeter \n 6.Get Rectangle Area \n 7.Exit");
            string choice = Console.ReadLine();

            switch (choice)
            {
                case "1": Console.WriteLine("\n Current Lenth: " + rectangle.GetCurrentLength()); goto wrongChoice;
                case "2":
                    Console.WriteLine("\n Please enter the new length");
                    length = int.Parse(Console.ReadLine());
                    int l = rectangle.SetNewLength(length);
                    Console.WriteLine("\n Length is changed to " + l);
                    goto wrongChoice;
                case "3": Console.WriteLine("\n Current Width: " + rectangle.GetCurrentWidth()); goto wrongChoice;
                case "4":
                    Console.WriteLine("\n Please enter new width");
                    width = int.Parse(Console.ReadLine());
                    int w = rectangle.SetNewWidth(width);
                    Console.WriteLine("\n Width is changed to " + w);
                    goto wrongChoice;
                case "5": Console.WriteLine("\n Perimeter: " + rectangle.GetPerimeter()); goto wrongChoice;
                case "6": Console.WriteLine("\n Area: " + rectangle.GetArea()); goto wrongChoice;
                case "7": Environment.Exit(0); break;
                default: goto wrongChoice;

            }
        }
    }
}
